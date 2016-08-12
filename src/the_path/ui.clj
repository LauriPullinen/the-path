(ns the-path.ui
  (:require [lanterna.screen :as s]))

(defn initialize
  [screen-type]
  (let [screen (s/get-screen screen-type)]
    (s/start screen)
    screen))

(defn terminate
  [screen]
  (s/stop screen))

(defn land->str
  [land]
  (case land
    :forest "^"
    :mountain "."
    ""))

(defn render-map
  [screen map]
  (let [height (count map)
        width (count (get map 0))]
    (doseq [y (range height)]
      (doseq [x (range width)]
        (s/put-string screen x y (land->str (get-in map [y x])))))))

(defn render-player
  [screen player]
  (let [x (:x (:position player))
        y (:y (:position player))]
    (s/put-string screen x y "@")))

(defn render
  [screen game]
  (let [map (get-in game [:world :map])
        player (get-in game [:world :player])]
    (s/clear screen)
    (render-map screen map)
    (render-player screen player)
    (s/put-string screen 0 10 (str "Debug: <" (:debug game) ">"))
    (s/redraw screen)
    screen))

(defn get-input
  [screen]
  (s/get-key-blocking screen))