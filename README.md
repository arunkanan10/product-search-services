A spring boot application [micro service API server] that serves as fulfillment for Product Search Services

**Features:**
Product Search Services supports search operations based on by it's name, brand, color, size.

##API /product/search
Filters considered from request body whose values are not null. Search supports one or more filter options.

**Sample Request :**

{
	"productName": "Formal Shirts",
	"brand": "",
	"size": "XL",
	"sku": ""
}

**Sample Response :**
[
    {
        "id": 1,
        "productName": "Formal Shirts",
        "sku": "abc12345",
        "brand": "Peter England",
        "price": 1000.5,
        "color": "Blue",
        "size": "XL",
        "productCategoryId": 1,
        "productInventories": [
            {
                "id": 1,
                "productId": 1,
                "inventory": 10
            }
        ]
    },
    {
        "id": 2,
        "productName": "Formal Shirts",
        "sku": "abc12346",
        "brand": "Peter England",
        "price": 999.5,
        "color": "Red",
        "size": "M",
        "productCategoryId": 1,
        "productInventories": [
            {
                "id": 2,
                "productId": 2,
                "inventory": 2
            }
        ]
    }
]
