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


