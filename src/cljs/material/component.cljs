(ns material.component
  (:refer-clojure :exclude [stepper list])
  (:require [material.factory :as f]
            [material.validation]
            [sablono.core :refer-macros [html]]))

;;; Theme components

(def theme-props
  {:palette {:primary   {:main "#65519f"}
             :secondary {:main "#f91556"}}})

(def theme (f/create-mui-theme (clj->js theme-props)))

(defn mui [component]
  (f/mui-theme-provider (clj->js {:theme theme}) (f/css-baseline) component))

;;; Single material-ui components

(defn divider
  ([props] (f/divider (clj->js props)))
  ([] (f/divider nil)))

(defn form-control
  [props & childs]
  (f/form-control (clj->js props) childs))

(defn form-group
  [props & childs]
  (f/form-group (clj->js props) childs))

(defn form-helper-text
  [props & childs]
  (f/form-helper-text (clj->js props) childs))

(defn toolbar
  [props & childs]
  (f/toolbar (clj->js props) childs))

(defn drawer
  [props & childs]
  (f/drawer (clj->js props) childs))

(defn list-item
  [props & childs]
  (f/list-item (clj->js props) childs))

(defn menu
  [props & childs]
  (f/menu (clj->js props) childs))

(defn input-label
  [props label]
  (f/input-label (clj->js props) label))

(defn input
  [props]
  (f/input (clj->js props)))

(defn list-item-text
  [props]
  (f/list-item-text (clj->js props)))

(defn list-item-icon
  [props icon]
  (f/list-item-icon (clj->js props) icon))

(defn input-adornment
  [props adorment]
  (f/input-adornment (clj->js props) adorment))

(defn icon-button
  [props icon]
  (f/icon-button (clj->js props) icon))

(defn button
  [props label]
  (f/button (clj->js props) label))

(defn menu-item
  [props label]
  (f/menu-item (clj->js props) label))

(defn app-bar
  [props drawer]
  (f/appbar (clj->js props) drawer))

(defn typography
  [props label]
  (f/typography (clj->js props) label))
































(defn auto-complete
  ([props] (f/auto-complete (clj->js props)))
  ([] (f/auto-complete nil)))

(defn avatar
  ([props] (f/avatar (clj->js props)))
  ([] (f/avatar nil)))

(defn snackbar
  ([props] (f/snackbar (clj->js props)))
  ([] (f/snackbar nil)))

(defn toogle
  ([props] (f/toogle (clj->js props)))
  ([] (f/toogle nil)))

(defn checkbox
  ([props] (f/checkbox (clj->js props)))
  ([] (f/checkbox nil)))

(defn slider
  ([props] (f/slider (clj->js props)))
  ([] (f/slider nil)))

(defn linear-progress
  ([props] (f/linear-progress (clj->js props)))
  ([] (f/linear-progress nil)))

(defn circular-progress
  ([props] (f/circular-progress (clj->js props)))
  ([] (f/circular-progress nil)))

(defn refresh-indicator
  ([props] (f/refresh-indicator (clj->js props)))
  ([] (f/refresh-indicator nil)))

(defn text-field
  ([props] (f/text-field (clj->js props)))
  ([] (f/text-field nil)))

(defn flat-button
  ([props] (f/flat-button (clj->js props)))
  ([] (f/flat-button nil)))

(defn radio-button
  ([props] (f/radio-button (clj->js props)))
  ([] (f/radio-button nil)))

(defn raised-button
  ([props & childs] (f/raised-button (clj->js props) childs))
  ([props] (f/raised-button (clj->js props)))
  ([] (f/raised-button nil)))














(defn dialog
  [props & childs]
  (f/dialog (clj->js props) childs))



(defn icon-menu
  [props & childs]
  (f/icon-menu (clj->js props) childs))

(defn select-field
  [props & childs]
  (f/select-field (clj->js props) childs))

(defn tab
  [props & childs]
  (f/tab (clj->js props) childs))

(defn tabs
  [props & childs]
  (f/tabs (clj->js props) childs))

(defn table
  [props & childs]
  (f/table (clj->js props) childs))

(defn table-header
  [props & childs]
  (f/table-header (clj->js props) childs))

(defn table-header-column
  [props comp]
  (f/table-header-column (clj->js props) comp))

(defn table-body
  [props & childs]
  (f/table-body (clj->js props) childs))

(defn table-row
  [props & childs]
  (f/table-row (clj->js props) childs))

(defn table-row-column
  ([props comp] (f/table-row-column (clj->js props) comp))
  ([props] (f/table-row-column (clj->js props))))

(defn table-footer
  [props & childs]
  (f/table-footer (clj->js props) childs))

(defn radio-button-group
  [props & childs]
  (f/radio-button-group (clj->js props) childs))

(defn svg
  ([props d] (f/svg-icon (clj->js props) (html [:path {:d d}])))
  ([d] (f/svg-icon nil (html [:path {:d d}]))))

(defn button-icon
  [icon]
  (html [:svg {:width  "18"
               :height "18"
               :fill   "rgb(117, 117, 117)"}
         [:path {:d icon}]]))

;;; Composite components

;(defn vtextfield [props]
;  (vtext-field
;    (merge props
;           {:required      true
;            :underlineShow false
;            :inputStyle    {:color "rgb(117, 117, 117)"}})))

(defn loader [props]
  (refresh-indicator
    (merge props
           {:size  30
            :left  8
            :style {:display  "inline-block"
                    :position "relative"}})))

(defn autocomplete [props]
  (auto-complete
    (merge props
           {:listStyle {:overflow-y "scroll"
                        :maxHeight  "230px"}})))

(defn progress-button [props progress?]
  (let [disabled? (:disabled props)]
    [:div {:style {:position "relative"}}
     (mui
       (raised-button
         (assoc props :disabled (or disabled? progress?))))
     (when progress?
       (mui
         (circular-progress {:size  24
                             :style {:zIndex     1000
                                     :position   "absolute"
                                     :top        "50%"
                                     :left       "50%"
                                     :marginTop  -12
                                     :marginLeft -12}})))]))