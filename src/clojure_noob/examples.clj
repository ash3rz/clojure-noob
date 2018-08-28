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
