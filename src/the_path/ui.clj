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

(defn render
  [screen game]
  (let [map (get-in game [:world :map])
        player (get-in game [:world :player])]
    (s/put-string screen 0 0 (str "Player: " (:position player)))
    (s/put-string screen 0 1 (str "Debug: <" (:debug game) ">"))
    (s/redraw screen)
    screen))

(defn get-input
  [screen]
  (s/get-key-blocking screen))