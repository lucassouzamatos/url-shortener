(ns url-shortener.repositories.url_repository
  (:require 
    [url-shortener.states.connection :refer [conn]]
    [clojure.java.jdbc :as jdbc]))

(defn insert!
  [values]
  (jdbc/insert! conn :url values))

(defn create-uri 
  [original hash]
  (insert! {:original original :hash hash})
  hash)
