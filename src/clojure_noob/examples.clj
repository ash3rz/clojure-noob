(ns clojure-noob.examples
  (:gen-class))

;Sample function with argument
(defn error-message
  [severity]
  (str "OH GOD! IT'S A DISASTER! WE'RE "
       (if (= severity :mild)
         "MILDLY INCONVENIENCED!"
         "DOOOOOOOMED!")))

;Maps
(get {:a 0 :b 1} :b)
; => 1

(get {:a 0 :b {:c "ho hum"}} :b)
; => {:c "ho hum"}

(get {:a 0 :b 1} :c "unicorns?")
; => "unicorns?"

(get-in {:a 0 :b {:c "ho hum"}} [:b :c])
; => "ho hum"

({:name "The Human Coffeepot"} :name)
; => "The Human Coffeepot"

;Keywords
(:a {:a 1 :b 2 :c 3})
; => 1

(:d {:a 1 :b 2 :c 3} "No gnome knows homes like Noah knows")
; => "No gnome knows homes like Noah knows"


;Vectors vs Lists
[1 2 3 4]
'(1 2 3 4)

(get [1 2 3] 0)
(nth '(1 2 3) 0)

(vector "this" "that" :other)
(list "this" "that" :other)

(conj [1 2 3] 4)
; => [1 2 3 4]
(conj '(1 2 3) 4)
; => (4 1 2 3)



;Functions
;You can do different things depending on the arity of the parameters
(defn greet
  ([] (greet "you"))
  ([name] (greet name "!"))
  ([name symbol] (print "Hello" name symbol)))

(defn x-chop
  "Describe the kind of chop you're inflicting on someone"
  ([name chop-type] 
   (str "I " chop-type " chop " name "! Take that!"))
  ([name]
   (x-chop name "karate")))
  

;
(defn codger-communication
  [whippersnapper]
  (str "Get off my lawn, " whippersnapper "!!!"))

(defn codger
  [& whippersnappers]
  (map codger-communication whippersnappers))

(codger "Billy" "Anne-Marie" "The Incredible Bulk")
;


;Destructuring
;Lists/Vectors
(defn chooser
  [[first-choice second-choice & unimportant-choices]]
  (println (str "Your first choice is: " first-choice))
  (println (str "Your second choice is: " second-choice))
  (println (str "We're ignoring the rest of your choices. "
                "Here they are in case you need to cry over them: "
                (clojure.string/join ", " unimportant-choices))))

(chooser ["Marmalade", "Handsome Jack", "Pigpen", "Aquaman"])

;Maps
(defn announce-treasure-location
  [{lat :lat lng :lng}]
  (println (str "Treasure lat: " lat))
  (println (str "Treasure lng: " lng)))

(announce-treasure-location {:lat 28.22 :lng 81.33})

;Maps - shorter syntax
(defn announce-treasure-location-short
  [{:keys [lat lng]}]
  (println (str "Treasure lat: " lat))
  (println (str "Treasure lng: " lng)))

;Destructuring while also maintaining the original props/map
(defn receive-treasure-location
  [{:keys [lat lng] :as treasure-location}]
  (println (str "Treasure lat: " lat))
  (println (str "Treasure lng: " lng))

  ;; One would assume that this would put in new coordinates for your ship
  (str treasure-location))




;Let
;The value of a let form is the last form in its body that is evaluated.
(def dalmatian-list
  ["Pongo" "Perdita" "Puppy 1" "Puppy 2"])
(let [dalmatians (take 2 dalmatian-list)]
  dalmatians)
; => ("Pongo" "Perdita")
(let [[pongo & dalmatians] dalmatian-list]
  [pongo dalmatians])
; => ["Pongo" ("Perdita" "Puppy 1" "Puppy 2")]
(def x 0)
(let [y (inc x)] y)
; => 1
(let [y (inc x)] x)
; => 0
; This is the same as above, but this is WAY MORE READABLE
(let [y (inc x)] 
  y)
; OMG REMEMBER THIS -- The value of a let form is the last form in its body that is evaluated.




;Loops
(loop [iteration 0]
  (println (str "Iteration " iteration))
  (if (> iteration 3)
    (println "Goodbye!") ;my exit
    (recur (inc iteration)))) ;loop
; => Iteration 0
; => Iteration 1
; => Iteration 2
; => Iteration 3
; => Iteration 4
; => Goodbye!

; This could also be written this way, but apparently loop has better performance:
(defn recursive-printer
  ([] (recursive-printer 0))
  ([iteration]
    (println "Iteration" iteration)
    (if (> iteration 3)
      (println "Goodbye!")
      (recursive-printer (inc iteration)))))
(recursive-printer)




;Regex
