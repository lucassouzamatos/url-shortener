(ns url-shortener.repositories.url_repository
  (:require 
    [url-shortener.states.connection :refer [conn]]
    [clojure.java.jdbc :as jdbc]))

(defn insert!
  [values]
  (jdbc/insert! conn :url values))

(defn get-document-by!
  [key value]
  (let [query ["select * from url where hash = ?" value]
        rows  (jdbc/query conn query)]
    (if (empty? rows)
      nil
      (first rows))))

(defn create-uri 
  [original hash]
  (insert! {:original original :hash hash})
  hash)

(defn get-by-hash [value] (->> value (get-document-by! "hash" ,,,)))
