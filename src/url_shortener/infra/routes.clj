(ns url-shortener.infra.routes
  (:require [org.httpkit.server :as server]
            [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer :all]
            [clojure.pprint :as pp]
            [clojure.string :as str]
            [clojure.data.json :as json]
            [url-shortener.controllers.hello_controller :as hello-controller]))

(defroutes app-routes
  (GET "/hello" [] hello-controller/hello-name)
  (route/not-found "Error, page not found!"))