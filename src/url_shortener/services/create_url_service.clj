(ns url-shortener.services.create_url_service
  (:require [url-shortener.repositories.url_repository :as url_repository])
  (:import clojure.lang.Murmur3))

(defn hash-url
  [url] 
  (format "%x" (Murmur3/hashUnencodedChars url)))

(defn generate-url
  [url]
  (let [hashed (hash-url url)]
    (url_repository/create-uri url hashed)))