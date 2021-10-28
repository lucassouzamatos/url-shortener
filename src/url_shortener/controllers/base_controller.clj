(ns url-shortener.controllers.base_controller
  (:require [ring.util.response :refer [response]]))

(defn success 
  [data]
  "Return a success response with status 200"
  (assoc (response {:data data}) :status 200))