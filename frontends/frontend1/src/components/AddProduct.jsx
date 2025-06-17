import {useState} from 'react';
import axios from 'axios';

const AddProduct = () => {
  const [product,setProduct] = useState({
    "productId":'',
    "productName":'',
    "productPrice":'',
    "brand":''
  });

  const handleChange = (e) => {
    const { name, value } = e.target;
    setProduct((prev) => ({
      ...prev,
      [name]: value
    }));
  };

  async function onSubmit(){
    console.log(product);
    await axios.post("http://localhost:8080/api/product",product);
    console.log("Product submitted");
  }

  return (
    <div>
      <div className="form-container">
        <h2 className="form-title">Add Product</h2>
        <form className="product-form" onSubmit={()=>onSubmit()}>
            <input
            name="productId"
            placeholder="Id"
            value={product.productId}
            onChange={handleChange}
          />
          <input
            name="productName"
            placeholder="Name"
            value={product.name}
            onChange={handleChange}
          />
          <input
            name="productPrice"
            placeholder="Price"
            value={product.price}
            onChange={handleChange}
          />
          <input
            name="brand"
            placeholder="Brand"
            value={product.brand}
            onChange={handleChange}
          />
          <button type="submit">Submit</button>
        </form>
      </div>
    </div>
  )
}

export default AddProduct
