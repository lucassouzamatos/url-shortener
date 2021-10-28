(ns url-shortener.services.create_url_service
  (:require [url-shortener.repositories.url_repository :as url_repository])
  (:import clojure.lang.Murmur3))

(defn- hash-url
  [url] 
  (format "%x" (Murmur3/hashUnencodedChars url)))

(def base-url "http://localhost:4000/")

(defn generate-url
  [url]
  (let [hashed (hash-url url)]
    (url_repository/create-uri url hashed)
    {:url (str base-url hashed)}))

(defn get-url-by-hash
  [hash]
  (let [document (url_repository/get-by-hash hash)]
    (document :original)))