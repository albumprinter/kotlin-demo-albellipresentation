package clients.cartapi

import clients.cartapi.models.*
import java.util.*

fun generate15EuroVoucher(cartId: String) = ShoppingCartItem(
    amount = 1,
    storedProductID = 0,
    configuration = ArticleConfigurationDto(
        article = ArticleDto(
            ID = "PAP_050"
        ),
        chosenExtras = ChosenExtrasDto(
            decidedOnGlossy = false,
            decidedOnFloatingFrame = false,
            decidedOnLayflat = false,
            decidedOnLinnen = false,
            decidedOnSmallerCopy = false,
            decidedOnWrapper = false,
            chosenVoucherDiscount = ChosenVoucherDiscountDto(
                option = VoucherDiscountOptionDto(
                    title = null,
                    ID = "Fixed1"
                )
            )
        )
    ),
    template = Template(
        predesignedProductID = UUID.fromString("a13db0ae-8225-4e8e-ac35-7326aad2d7f6")
    ),
    channelName = "albelli.nl",
    editorTypeID = "CMS",
    productTitle = "Cadeaubon €15"
)
