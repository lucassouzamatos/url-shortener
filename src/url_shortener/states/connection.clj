(ns url-shortener.states.connection
  (:require
    [mount.core :refer [defstate]]))

(defstate conn :start "started")