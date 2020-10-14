package clients.cartapi

import clients.cartapi.models.*
import kotlinx.coroutines.runBlocking
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.client.*

class CartApiClient(private val baseUrl: String) {
    private val webClient = WebClient.create(baseUrl)
    suspend fun createEmptyCart(channel: String): ShoppingCart? {
        val request = NewShoppingCart(channel = channel)
        return webClient.post()
            .uri("/Carts")
            .accept(MediaType.APPLICATION_JSON)
            .bodyValue(request)
            .awaitExchange()
            .awaitBodyOrNull()
    }
    fun createEmptyCartBlocking(channel: String): ShoppingCart? = runBlocking { createEmptyCart(channel) }

    suspend fun addVoucher(cartId: String): ShoppingCartItem? {
        val request = generate15EuroVoucher(cartId)
        return webClient.post()
            .uri("/Carts/$cartId/Items")
            .accept(MediaType.APPLICATION_JSON)
            .bodyValue(request)
            .awaitExchange()
            .awaitBodyOrNull()
    }
    fun addVoucherBlocking(cartId: String) = runBlocking { addVoucher(cartId) }

    suspend fun getCart(cartId: String): ShoppingCart? {
        return webClient.get()
            .uri("/Carts/$cartId")
            .accept(MediaType.APPLICATION_JSON)
            .awaitExchange()
            .awaitBodyOrNull()
    }
    fun getCartBlocking(cartId: String): ShoppingCart? = runBlocking { getCart(cartId) }



}