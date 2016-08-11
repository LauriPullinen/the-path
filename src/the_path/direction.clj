(ns the-path.direction)

(defn direction->coordinate-change
  [direction]
  (case direction
    :north {:x 0 :y -1}
    :west {:x -1 :y 0}
    :east {:x 1 :y 0}
    :south {:x 0 :y 1}))