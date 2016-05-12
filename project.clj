(defproject new "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.4.0"]
                 [congomongo "0.3.3"]
                 [clojureql "1.0.4"]
                 [rplevy-draker/wabbitmq "0.3.0" :exclusions [org.clojure/clojure]]
                 [com.mysql/connectorj "5.1.12"]
                 [org.clojure/core.match "0.2.0-alpha11"]
                 [org.clojure/core.logic "0.7.5"]
                 [clojurewerkz/elastisch "1.0.2"]
                 [clojurewerkz/neocons "1.1.0-beta2"]
                 [clj-gremlin "0.0.3"]
                 [gavagai "0.3.1"]
                 [prismatic/plumbing "0.0.1"]])
