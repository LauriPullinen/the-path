(ns the-path.game
  (:require [the-path.direction :refer :all])
  (:require [the-path.map :as map]))

(defn start
  [game]
  (assoc game :screen :play))

(defn move
  [game direction]
  (let [current-position (get-in game [:world :player :position])
        movement (direction->coordinate-change direction)
        next-position (merge-with + current-position movement)
        map (get-in game [:world :map])]
    (if (map/can-move map next-position)
      (assoc-in game [:world :player :position] next-position)
      game)))

(defn quit
  [game]
  (assoc game :running false))

(defn initialize
  []
  {:running true
   :screen :menu
   :world {:player {:position {:x 0 :y 0}}
           :map (map/initialize)}
   :debug ""})