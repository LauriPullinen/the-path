(ns the-path.core
  (:require the-path.game)
  (:require the-path.ui)
  (:require the-path.controller)
  (:gen-class))

(defn -main
  [& args]
  (loop [game (the-path.game/initialize)
         ui (the-path.ui/initialize :swing)]
    (let [next-ui (the-path.ui/render ui game)
          input (the-path.ui/get-input ui)
          next-game (the-path.controller/handle-input game input)]
      (if (true? (:running next-game))
        (recur next-game next-ui)
        (the-path.ui/terminate ui)))))
