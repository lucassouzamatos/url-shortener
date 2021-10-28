(ns url-shortener.core
  (:require [org.httpkit.server :as server]
            [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer :all]
            [clojure.pprint :as pp]
            [clojure.string :as str]
            [clojure.data.json :as json]
            [ring.middleware.keyword-params :refer [wrap-keyword-params]]
            [ring.middleware.params :refer [wrap-params]]
            [mount.core :as mount]
            [ring.middleware.json :refer [wrap-json-response wrap-json-body]]
            [url-shortener.infra.routes :as infra-routes]
            [url-shortener.infra.migrations :as infra-migrations]
            [url-shortener.states.connection :refer [conn]])
  (:gen-class))

(defn wrap 
  [handler]
  (-> handler
    (wrap-keyword-params)
    (wrap-params)
    (wrap-json-response)
    (wrap-json-body {:keywords? true :bigdecimals? true})))

(defn -main
  "This is our main entry point"
  [& args]
  (let [port (Integer/parseInt (or (System/getenv "PORT") "4000"))]
    (mount/start)
    (infra-migrations/startup)
    (server/run-server (wrap #'infra-routes/app-routes) {:port port})
    (println (str "Running webserver at http:/127.0.0.1:" port "/"))))