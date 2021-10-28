(ns url-shortener.repositories.base_repository
    (:require 
      [url-shortener.states.connection :refer [conn]]
      [clojure.string :as str]
      [clojure.java.jdbc :as jdbc]))

(defn insert!
    [values]
    (jdbc/insert! conn :url values))
  
(defn prepare-statement
  [key]
  (str/replace "select * from url where key = ?" #"key" key))
  
(defn get-document-by!
  [key value]
  (let [statement (prepare-statement key)
        query [statement value]
        rows  (jdbc/query conn query)]
    (if (empty? rows)
      nil
      (first rows))))