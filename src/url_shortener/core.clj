(ns url-shortener.core
  (:require [org.httpkit.server :as server]
            [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer :all]
            [clojure.pprint :as pp]
            [clojure.string :as str]
            [clojure.data.json :as json]
            [url-shortener.infra.routes :as infra-routes])
  (:gen-class))

;; this is an only test for wrapping fn
;; can got user in handlers above:
;; (defn handler [req]
;;   (let [user (:user req)]
;;     (println "user -> " user)
(defn wrap-user 
  [handler]
  (fn ([request]
        (handler (merge-with into request {:user 1})))))

(defn -main
  "This is our main entry point"
  [& args]
  (let [port (Integer/parseInt (or (System/getenv "PORT") "4000"))]
    (server/run-server (wrap-user (wrap-defaults #'infra-routes/app-routes site-defaults)) {:port port})
    (println (str "Running webserver at http:/127.0.0.1:" port "/"))))