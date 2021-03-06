package com.example

import pl.treksoft.kvision.core.Border
import pl.treksoft.kvision.core.BorderStyle
import pl.treksoft.kvision.core.Col
import pl.treksoft.kvision.hmr.ApplicationBase
import pl.treksoft.kvision.panel.Root
import pl.treksoft.kvision.panel.TabPanel.Companion.tabPanel
import pl.treksoft.kvision.require
import pl.treksoft.kvision.utils.auto
import pl.treksoft.kvision.utils.perc
import pl.treksoft.kvision.utils.px

class Showcase : ApplicationBase {

    override fun start(state: Map<String, Any>) {
        Root("showcase") {
            tabPanel {
                width = 80.perc
                margin = 20.px
                marginLeft = auto
                marginRight = auto
                padding = 20.px
                border = Border(2.px, BorderStyle.SOLID, Col.SILVER)
                addTab("Basic formatting", BasicTab(), "fa-bars", route = "/basic")
                addTab("Forms", FormTab(), "fa-edit", route = "/forms")
                addTab("Buttons", ButtonsTab(), "fa-check-square-o", route = "/buttons")
                addTab("Dropdowns & Menus", DropDownTab(), "fa-arrow-down", route = "/dropdowns")
                addTab("Containers", ContainersTab(), "fa-database", route = "/containers")
                addTab("Layouts", LayoutsTab(), "fa-th-list", route = "/layouts")
                addTab("Modals", ModalsTab(), "fa-window-maximize", route = "/modals")
                addTab("Data binding", DataTab(), "fa-retweet", route = "/data")
                addTab("Windows", WindowsTab(), "fa-window-restore", route = "/windows")
                addTab("Drag & Drop", DragDropTab(), "fa-arrows-alt", route = "/dragdrop")
            }
        }
    }

    override fun dispose(): Map<String, Any> {
        return mapOf()
    }

    companion object {
        val css = require("./css/showcase.css")
    }
}
