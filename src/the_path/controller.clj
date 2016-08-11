(ns the-path.controller
  (:require [the-path.game :refer :all]))

(defn handle-input
  [game input]
  (case input
    \b (start game)
    :up (move game :north)
    :left (move game :west)
    :right (move game :east)
    :down (move game :south)
    \q (quit game)
    (assoc game :debug input)))