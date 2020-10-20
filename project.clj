(defproject oxy-bee "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :main ^:skip-aot oxy-bee.core
  :dependencies [[org.clojure/clojure "1.10.0"]
                 [http-kit "2.5.0"]
                 [metosin/reitit "0.5.6"]
                 [cambium/cambium.core           "1.0.0"]
                 [cambium/cambium.codec-cheshire "1.0.0"]
                 [cambium/cambium.logback.json   "0.4.4"]]
  :plugins      [[lein-cljfmt "0.5.6"]
                 [lein-cloverage "1.1.2"]
                 [jonase/eastwood "0.3.11"]]
  :repl-options {:init-ns oxy-bee.core})
