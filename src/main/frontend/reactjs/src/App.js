import './App.css';
import axios from "axios";
import React, {useState, useEffect, useCallback} from "react";
import {useDropzone} from "react-dropzone";

const UserProfiles = () => {

  const [userProfiles, setUserProfiles] = useState([]);
  const fetchUserProfiles = () => {
    axios.get("http://localhost:8080/api/user/profile").then(res => {
      setUserProfiles(res.data);
    });
  };
  useEffect(() => {
    fetchUserProfiles();
    }, []);
  return userProfiles.map((userProfile, index) => {
    return (
        <div key={index}>
            <Dropzone/>
          <h1>{userProfile.username}</h1>
          <p>{userProfile.userProfileId}</p>
        </div>
    );
  });
};

function App() {
    return (
        <div className="App">
            <UserProfiles/>
        </div>
    )}

function Dropzone(){
    const onDrop = useCallback(acceptedFiles => {
        const file = acceptedFiles[0];
        console.log(file);
        /*
        const formData = new FormData();
        formData.append("file", file);
        axios.post("http://localhost:8080/api/user/profile/${userProfileId}/image/upload" ,
            formData,
            {
                headers: {
                    "Content-type": "multipart/form-data"
                }
            })
            .then(()=>{
                console.log("Succes!")
            })
            .catch(err=>{
                console.log(err)
            })
*/
    }, [])
    const {getRootProps, getInputProps, isDragActive} = useDropzone({onDrop})

    return (
        <div {...getRootProps()}>
             <input {...getInputProps()} />
             {
                 isDragActive ?
                     <p>Drop the files here ...</p> :
                     <p>Drag 'n' drop some files here, or click to select files</p>
             }
         </div>
     )
 }

export default App;

