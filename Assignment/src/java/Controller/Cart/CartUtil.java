/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.Cart;

import Models.Cart.CartProduct;
import com.sun.net.httpserver.HttpServer;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author admin
 */
public class CartUtil {
    public HashMap<String, CartProduct> getCartFromCookie(Cookie cookieCart){
        HashMap<String, CartProduct> cart = null;
        String[] arrProductDetail;
        String productID, productName;
        int quantity;
        float price;
        CartProduct product;
        Base64.Decoder base64Decoder = Base64.getDecoder();
        cart = new HashMap();
        String encodedString = new String (base64Decoder.
                decode(cookieCart.getValue().getBytes()));
        String[] productList = encodedString.split("\\|");
        for(String strPro : productList){
            arrProductDetail = strPro.split(",");
            productID = arrProductDetail[0].trim();
            productName = arrProductDetail[1].trim();
            quantity = Integer.parseInt(arrProductDetail[2].trim());
            price = Float.parseFloat(arrProductDetail[3]);
            product = new CartProduct(productID, productName, quantity, price);
            cart.put(productID, product);
        }
        return  cart;
    }
    
    public Cookie getCookieByName(HttpServletRequest request, String cookieName){
        Cookie[] arrCookies = request.getCookies();
        if(arrCookies != null){
            for(Cookie cookie: arrCookies){
                if(cookie.getName().equals(cookieName)){
                    return cookie;
                }
            }
        }
        return null;
    }
    
    public void saveCartToCookie(HttpServletRequest request, 
            HttpServletResponse response, String strItemsInCart){
        String cookieName = "Cart";
        Cookie cookieCart = getCookieByName(request, cookieName);
        if(cookieCart != null){
            cookieCart.setValue(strItemsInCart);
        }else{
            cookieCart = new Cookie(cookieName, strItemsInCart);
        }
        cookieCart.setMaxAge(30);
        response.addCookie(cookieCart);
    }
    
    public String ConvertCartToString(List<CartProduct> itemsList){
        StringBuilder strItemsInCart = new StringBuilder();
        for(CartProduct item : itemsList){
            strItemsInCart.append(item + "|");
        }
        Base64.Encoder base64Encoder = Base64.getEncoder();
        String encodedString = base64Encoder.
                encodeToString(strItemsInCart.toString().getBytes());
        return encodedString;
    }
}
