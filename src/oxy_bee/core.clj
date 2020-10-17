(ns oxy-bee.core
  (:require [org.httpkit.server :as http-server]
            [reitit.ring :as ring]
            [muuntaja.core :as m]
            [reitit.ring.middleware.muuntaja :refer [format-request-middleware
                                                     format-response-middleware]]
            [cambium.codec :as codec]
            [cambium.logback.json.flat-layout :as flat]
            [cambium.core :as log]))

(def routes
  ["/ping" {:get (fn [_] {:status 200
                          :body {:message "pong"}})}])

(def app
  (ring/ring-handler
    (ring/router
      [["/api"
        routes]]
      {:data {:muuntaja   m/instance
              :middleware [format-response-middleware
                           format-request-middleware]}})
    (ring/routes
      (ring/redirect-trailing-slash-handler)
      (ring/create-default-handler
        {:not-found (constantly {:status 404 :body "Route not found"})}))))

(defn- start-server []
  (log/info "Starting server...")
  (http-server/run-server app {:port 8080})
  (log/info "Server started..."))

(defn -main [& args]
  (flat/set-decoder! codec/destringify-val)
  (start-server))
