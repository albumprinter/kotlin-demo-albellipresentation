/**
* CartApi
* No description provided (generated by Openapi Generator https://github.com/openapitools/openapi-generator)
*
* The version of the OpenAPI document: api
* 
*
* NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
* https://openapi-generator.tech
* Do not edit the class manually.
*/
package clients.cartapi.models


import com.fasterxml.jackson.annotation.JsonProperty
/**
 * 
 * @param fromDate 
 * @param toDate 
 * @param anonymous 
 * @param empty 
 * @param skip 
 * @param take 
 */

data class FetchCarts (
    @JsonProperty("FromDate")
    val fromDate: java.time.OffsetDateTime,
    @JsonProperty("ToDate")
    val toDate: java.time.OffsetDateTime,
    @JsonProperty("Anonymous")
    val anonymous: kotlin.Boolean? = null,
    @JsonProperty("Empty")
    val empty: kotlin.Boolean? = null,
    @JsonProperty("Skip")
    val skip: kotlin.Int? = null,
    @JsonProperty("Take")
    val take: kotlin.Int? = null
)

