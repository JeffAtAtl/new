(ns new.rabbitmq)

(import (com.rabbitmq.client ConnectionFactory Connection Channel QueueingConsumer))

;; And then we have to translate the equivalent java hello world program using
;; Clojure's excellent interop.

;; It feels very strange writing this sort of ceremony-oriented imperative code
;; in Clojure:

;; Make a connection factory on the local host
(def connection-factory
     (doto (ConnectionFactory.)
       (.setHost "10.0.0.7")))

;; and get it to make you a connection
(def connection (.newConnection connection-factory))

;; get that to make you a channel
(def channel (. connection createChannel))

;; And on that channel, create (or at least ensure the existence of) a queue,
;; named q, which is neither durable nor exclusive nor auto-deleted:
;;(. channel queueDeclare "hello" false false false nil)

;; Now we'll define a function to send n messages to q:
(defn send-hello 
  [n q]
  (. channel queueDeclare q false false false nil)
  (dotimes [ i n ]
  (. channel basicPublish "" q nil (. (format "Hello World! (%d)" i) getBytes))))

;; Strictly we're sending the messages to the default exchange "", using the
;; routing key "hello"

;; Now we want to retrieve our messages from the queue.

;; We create a consumer
(def consumer (new QueueingConsumer channel))

;; And attach it to the channel
;;(. channel basicConsume "hello" true consumer)

;; Now we'll define a function to receive n messages from q:
(defn recv-hello
  [n q]
  (. channel basicConsume q true consumer)
  (dotimes [ _ n]
  (let [delivery (. consumer nextDelivery)
        str (String. (. delivery getBody))]
          (println str))))