package com.albelli

import io.kotest.assertions.timing.eventually
import io.kotest.core.spec.style.BehaviorSpec
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.interactions.Actions
import kotlin.time.ExperimentalTime
import kotlin.time.seconds

@ExperimentalTime
class CheckoutOrderingTest : BehaviorSpec({
    val driver = ChromeDriver()
    driver.manage().deleteAllCookies()
    driver.manage().window().fullscreen()
    val builder = Actions(driver)
    Given("A Random Albelli Account") {
        val testAccount = object {
            val email = "kotlinwebinar@albelli.com"
            val password = "test123"
        }
        And("Albelli website is opened") {
            driver.get("https://albelli.nl")
        }
        AndContinually("Try to close any Albelli.nl popups", 5.seconds) {
            runWithoutExceptions {
                val closePopup = driver.findElement(".arc3-modal__close")
                builder.performClick(closePopup)
            }
        }
        AndEventually("More Products main menu is toggled", 5.seconds) {
            val wallDecorMenu =
                driver.findElement(".arc3-menu__main__nav > li > a[href\$=\"fotoproducten\"]")
            eventually(5.seconds) {
                builder.moveToElement(wallDecorMenu).perform()
            }
        }
        AndEventually("Voucher from the dropdown is chosen", 5.seconds) {
            val posterButton = driver.findElement(".arc3-menu__main__nav a[href\$=\"cadeaubonnen\"]")
            builder.performClick(posterButton)
        }
        AndEventually("Begin now is clicked", 5.seconds) {
            val button = driver.findElement(".voucher-cta")
            builder.performClick(button)
        }
        AndContinually("Try to close any Basket page popups", 5.seconds) {
            runWithoutExceptions {
                val closePopup = driver.findElement(".arc3-modal__close")
                builder.performClick(closePopup)
            }
        }
        AndEventually("Continue with the order is clicked", 10.seconds) {
            val button = driver.findElement("#LinkButtonProceedBottom")
            driver.get(button.getAttribute("href"));
        }
        AndEventually("Login page is reached", 5.seconds) {
            val email = driver.findElement("#Email")
            val password = driver.findElement("#Password")
            builder.performSendKeys(email, testAccount.email)
            builder.performSendKeys(password, testAccount.password)
            val loginSubmitButton = driver.findElement("input[type=\"submit\"]")
            builder.moveToElement(loginSubmitButton).click().perform()
        }
        AndContinually("Try to close any Details page popups", 5.seconds) {
            runWithoutExceptions {
                val closePopup = driver.findElement(".arc3-modal__close")
                builder.performClick(closePopup)
            }
        }
        AndEventually("Clicked the details button", 5.seconds) {
            val detailsButton = driver.findElement("#ToDeliveryDataButton")
            builder.performClick(detailsButton)
        }
    }
})