package com.albelli

import io.kotest.assertions.timing.continually
import io.kotest.assertions.timing.eventually
import io.kotest.core.spec.style.scopes.GivenScope
import org.openqa.selenium.WebElement
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.interactions.Actions
import kotlin.time.Duration
import kotlin.time.ExperimentalTime

fun ChromeDriver.findElement(cssSelector: String) = this.findElement(org.openqa.selenium.By.cssSelector(cssSelector))
fun Actions.performClick(element: WebElement) = this.click(element).perform()
fun Actions.performSendKeys(element: WebElement, value: String) = this.moveToElement(element).click().sendKeys(value).perform()
@ExperimentalTime
suspend fun GivenScope.AndEventually(name: String, duration: Duration, test: suspend GivenScope.() -> Unit){
    And(name) {
        eventually(duration) {
            test()
        }
    }
}
@ExperimentalTime
suspend fun GivenScope.AndContinually(name: String, duration: Duration, test: suspend GivenScope.() -> Unit){
    And(name) {
        continually(duration) {
            test()
        }
    }
}
suspend fun runWithoutExceptions(code: suspend () -> Unit){
    try{
        code()
    }
    catch (e: Exception){ }
}