/*import React, {useState} from 'react';
import './App.css';
import { tab } from '@testing-library/user-event/dist/tab';
import ImageGenerator from "./components/ImageGenerator";


function App() {

  const [activeTab , setActiveTab] = useState('image-generator');
  const changes=(tab)=>{
    //alert(tab)
    setActiveTab(tab)
  };
  return (
    <div className="App">
      <button className={activeTab === 'image-generator' ? 'active' : ''}
      onClick={()=>changes('image-generator')}>Image Generator</button>
      <button className={activeTab === 'chat' ? 'active' : ''}
      onClick={()=>changes('chat')}>Chat</button>
      <button className={activeTab === 'recipe-generator' ? 'active' : ''}
       onClick={()=>changes('recipe-generator')}>Recipe Generator</button>

       <div>
        {activeTab === 'image-generator' && <ImageGenerator/>}
        {activeTab === 'chat' && <h2>Chat</h2>}
        {activeTab === 'recipe-generator' && <h2>Recipe Generator</h2>}
      </div>
    </div>

     
     
  );

  
}

export default App;*/

import React, { useState } from 'react';
import './App.css';
import ImageGenerator from './components/ImageGenerator';
import ChatComponent from './components/ChatComponent';
import RecipeGenerator from './components/RecipeGenerator';

function App() {
  const [activeTab, setActiveTab] = useState('image-generator');

  const handleTabChange = (tab) => {
    //alert(tab)
    setActiveTab(tab);
  };

  return (
    <div className="App">
      <button className={activeTab === 'image-generator' ? 'active' : ''}
       onClick={() => handleTabChange('image-generator')}>
        Image Generator
        </button>
      <button  className={activeTab === 'chat' ? 'active' : ''}
      onClick={() => handleTabChange('chat')}>
        Ask AI
        </button>
      <button className={activeTab === 'recipe-generator' ? 'active' : ''}
      onClick={() => handleTabChange('recipe-generator')}>
        Recipe Generator
        </button>

        <div>
          {activeTab === 'image-generator' && <ImageGenerator/>}
          {activeTab === 'chat' && <ChatComponent/>}
          {activeTab === 'recipe-generator' && <RecipeGenerator/>}
        </div>
    </div>
  );
}

export default App;
