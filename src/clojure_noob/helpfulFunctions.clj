(ns clojure-noob.helpfulFunctions
  (:gen-class))

; Checking regexes
(re-find #"^left-" "left-eye")
; => "left-"
(re-find #"^left-" "cleft-chin")
; => nil
(re-find #"^left-" "wongleblart")
; => nil

; Putting stuff into other stuff
(into [] (set [:a :a :b]))
; => [:a :b]