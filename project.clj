(defproject the-path "0.1.0-SNAPSHOT"
  :description "The Path - A Post-Apocalyptic Survival Roguelike"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [clojure-lanterna "0.9.4"]]
  :main ^:skip-aot the-path.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
