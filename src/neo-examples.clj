(use 'new.neo)

(dir new.neo)

(->> (raw-eval-cypher 
       "start n=node(0) 
        match p=n-[r:likes*1..3]->a 
        return n.name, a.name, p")
     :data
     first
     last
     keys)

(->> (raw-eval-cypher 
       "start n=node(0) 
        match p=n-[r:likes*1..3]->a 
        return n.name, a.name, p")
     :data
     first
     last)

(->> (raw-eval-cypher 
       "start n=node(0) 
        match p=n-[r:likes*1..3]->a 
        return n.name, a.name, p")
     :data
     second
     last
     :start)

(->> (raw-eval-cypher 
       "start n=node(*) 
        match p=n-[r:likes*1..3]->a 
        return n.name, a.name, p")
     :data
     (map last)
     (map :length)
     sort
     reverse)

(->> (raw-eval-cypher 
       "start n=node(*) 
        match p=n-[r:likes*1..3]->a 
        return n.name, a.name, p")
     :data
     (map last)
     (map :length)
     frequencies)

(->> (raw-eval-cypher 
       "start n=node(*) 
        match p=n-[r:likes*1..3]->a 
        return n.name, a.name, p")
     :data
     (map last)
     (map :nodes)
     (map count)
     sort
     reverse)

(->> (raw-eval-cypher 
       "start n=node(*) 
        match p=n-[r:likes*1..3]->a 
        return n.name, a.name, p")
     :data
     (map last)
     (map :nodes)
     (map count)
     frequencies)