import { useParams } from "react-router-dom";
import {  useEffect, useState } from "react";
import axios from "../axios";

const Product = () => {
  const { id } = useParams();
const [product, setProduct] = useState(null);

  useEffect(() => {
    const fetchProduct = async () => {
      try {
        const response = await axios.get(`http://localhost:8080/api/product/${id}`);
        setProduct(response.data);
        console.log(response.data);
      } catch (error) {
        console.error("Error fetching product:", error);
      }
    };

    fetchProduct();
  }, [id]);

  if (!product) {
    return (
      <h2 className="text-center" style={{ padding: "10rem" }}>
        Loading...
      </h2>
    );
  }

  return (
    <>
      <div className="containers">
        <div className="right-column">
          <div className="product-description">
            <span>{product.category}</span>
            <h1>{product.productName}</h1>
            <h5>{product.brand}</h5>
            <p>{product.desc}</p>
          </div>

          <div className="product-price">
            <span>{"$" + product.productPrice}</span>
            <button
              className={`cart-btn ${!product.available ? "disabled-btn" : ""}`}
              disabled={!product.available}
            >
              {product.available ? "Add to cart" : "Out of Stock"}
            </button>
            <h6>
              Stock Available :{" "}
              <i style={{ color: "green", fontWeight: "bold" }}>
                {product.quantity}
              </i>
            </h6>
            <p className="release-date">
              <h6>Product listed on:</h6>
              <i>{product.releaseDate}</i>
            </p>
          </div>
          <div className="update-button ">
            <button
              className="btn btn-primary"
              type="button"
          
            >
              Update
            </button>
        
            <button
              className="btn btn-primary"
              type="button"
            >
              Delete
            </button>
          </div>
        </div>
      </div>
    </>
  );
};

export default Product;
