package definitions

import clients.cartapi.CartApiClient
import clients.cartapi.models.ShoppingCartItem
import io.cucumber.java8.En
import org.junit.Assert.*

@Suppress("unused")
class VoucherCartCreationDefinitions : En {
    private val cartApiClient = CartApiClient("https://cart.sandbox.ecom2.albelli.com")
    var cartId: String? = null
    var voucher: ShoppingCartItem? = null
    init {
        Given("An empty cart") {
            val createdCart = cartApiClient.createEmptyCartBlocking("albelli.nl")
            assertNotNull(createdCart?.ID)
            cartId = createdCart!!.ID!!
        }
        When("I add a new voucher to the newly created empty cart") {
            val addedCartItem = cartApiClient.addVoucherBlocking(cartId!!)
            assertNotNull(addedCartItem)
        }
        Then("Cart item is successfully created") {
            val cart = cartApiClient.getCartBlocking(cartId!!)
            val voucher = cart?.cartItems?.singleOrNull()
            assertNotNull(voucher)
            this.voucher = voucher
        }
        Then("The voucher inside the cart is the expected one") {
            assertEquals("PAP_050", voucher?.configuration?.article?.ID)
            assertEquals("Fixed1", voucher?.configuration?.chosenExtras?.chosenVoucherDiscount?.option?.ID)
        }
    }

}