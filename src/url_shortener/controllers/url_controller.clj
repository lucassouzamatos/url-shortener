(ns url-shortener.controllers.url_controller
  (:require 
    [url-shortener.services.create_url_service :as create-url-service]
    [url-shortener.controllers.base_controller :as base-controller]))

(defn create [req]
  (let [url 
    (-> req 
      :params 
      :url)]
    (-> url 
      create-url-service/generate-url 
      base-controller/success)))
