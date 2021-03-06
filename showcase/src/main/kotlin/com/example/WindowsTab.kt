package com.example

import pl.treksoft.kvision.form.check.CheckBox.Companion.checkBox
import pl.treksoft.kvision.form.text.Text
import pl.treksoft.kvision.form.text.TextInput
import pl.treksoft.kvision.form.text.TextInput.Companion.textInput
import pl.treksoft.kvision.form.text.TextInputType
import pl.treksoft.kvision.html.Button.Companion.button
import pl.treksoft.kvision.html.ButtonStyle
import pl.treksoft.kvision.panel.SimplePanel
import pl.treksoft.kvision.panel.VPanel.Companion.vPanel
import pl.treksoft.kvision.utils.px
import pl.treksoft.kvision.window.Window
import kotlin.js.Math.random

class WindowsTab : SimplePanel() {
    init {
        this.marginTop = 10.px
        this.minHeight = 400.px
        var counter = 1
        button("Open new window", style = ButtonStyle.PRIMARY, icon = "fa-window-maximize").onClick {
            val sw = ShowcaseWindow("Window " + counter++) {
                left = ((random() * 800).toInt()).px
                top = ((random() * 300).toInt()).px
            }
            add(sw)
            sw.focus()
        }
    }
}

class ShowcaseWindow(caption: String?, init: (ShowcaseWindow.() -> Unit)? = null) :
    Window(caption, 600.px, 300.px, closeButton = true) {

    lateinit var captionInput: TextInput

    init {
        init?.invoke(this)
        vPanel {
            margin = 10.px
            captionInput = textInput(TextInputType.TEXT, caption) {
                setEventListener<TextInput> {
                    change = {
                        this@ShowcaseWindow.caption = self.value
                    }
                }
            }
            checkBox(true, label = "Draggable").onClick {
                this@ShowcaseWindow.isDraggable = this.value
            }
            checkBox(true, label = "Resizable").onClick {
                this@ShowcaseWindow.isResizable = this.value
            }
            checkBox(true, label = "Close button").onClick {
                this@ShowcaseWindow.closeButton = this.value
            }
        }
    }

    override fun focus() {
        super.focus()
        captionInput.focus()
    }
}
