import React, { Component } from 'react';
import AddProduct from './Components/AddProduct';
import { Route, BrowserRouter as Router} from 'react-router-dom';
import Table from './Components/Table'


function App() {
  return (
    <Router>
      <Route exact path="/" component={AddProduct} />
      <Route exact path="/view" component={Table} />
    </Router>
  );
}

export default App;
