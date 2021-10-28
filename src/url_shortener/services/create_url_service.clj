(ns url-shortener.services.create_url_service
  (:require [url-shortener.repositories.url_repository :as url_repository]))

(defn generate-url
  [url]
  (url_repository/create-uri url url))