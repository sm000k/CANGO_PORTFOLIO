import './App.css';
import AppBar from './components/appbar';
import TextForm from './components/textForm';
import SimpleCompanySearch from './components/simplecompanysearch';
import SimpleServiceSearch from './components/simpleservicesearch';


function App() {
  return (
    <div className="App">
    <AppBar/>
    {/* <TextForm/> */}

    {<SimpleCompanySearch/>}
    {<SimpleServiceSearch/>}

    </div>
  );
}


export default App;
