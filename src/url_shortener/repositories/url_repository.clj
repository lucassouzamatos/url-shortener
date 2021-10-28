(ns url-shortener.repositories.url_repository
  (:require [url-shortener.repositories.base_repository :as base_repository]))

(defn create-uri 
  [original hash]
  (base_repository/insert! {:original original :hash hash})
  hash)

(defn get-by-hash 
  [value] 
  (base_repository/get-document-by! "url" "hash" value))
