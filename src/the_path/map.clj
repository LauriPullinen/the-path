(ns the-path.map)

(defn can-move
  [map to]
  (let [target-land (get-in map [(:y to) (:x to)])]
    (and (some? target-land) (= target-land :forest))))

(defn initialize
  []
  [[:forest :forest :forest :forest :forest]
   [:forest :forest :forest :forest :forest]
   [:forest :forest :forest :mountain :forest]
   [:forest :forest :forest :mountain :mountain]
   [:forest :forest :forest :forest :forest]])