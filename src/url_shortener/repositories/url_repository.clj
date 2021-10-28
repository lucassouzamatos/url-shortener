(ns url-shortener.repositories.url_repository
  (:require 
    [url-shortener.states.connection :refer [conn]]
    [clojure.java.jdbc :as jdbc]))

(defn create-uri 
  [original hash]
  (jdbc/insert! conn :url {:original original :hash hash})
  hash)
  