(ns url-shortener.controllers.base_controller
  (:require [ring.util.response :as response]))

(defn success 
  [data]
  "Return a success response with status 200"
  (assoc (response/response {:data data}) :status 200))

(defn redirect
  [url]
  "Redirect to specified url"
  (response/redirect url))