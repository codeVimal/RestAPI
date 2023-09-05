import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { useNavigate, useParams } from 'react-router-dom';
import Modal from 'react-modal';
import '../Profile.css';
Modal.setAppElement('#root');

function Profile() {
    const navigate = useNavigate();
  const { transactionId } = useParams();
  const [userDetails, setUserDetails] = useState({});
  const [isEditModalOpen, setIsEditModalOpen] = useState(false);
  const [editedUserDetails, setEditedUserDetails] = useState({
    transaction_id: transactionId,
    firstName: '',
    lastName: '',
    email: '',
    password: '',
  });

  useEffect(() => {
    async function fetchUserDetails() {
      try {
        const response = await axios.get(`http://localhost:8080/showbyid/${transactionId}`);
        setUserDetails(response.data);
      } catch (error) {
        console.error('Error fetching user details:', error);
      }
    }

    fetchUserDetails();
  }, [transactionId]);

  const openEditModal = () => {
    setEditedUserDetails(userDetails);
    setIsEditModalOpen(true);
  };

  const closeEditModal = () => {
    setIsEditModalOpen(false);
  };

  const handleSave = async () => {
    try {
        console.log(editedUserDetails);
      await axios.put(`http://localhost:8080/update`, editedUserDetails);
      setIsEditModalOpen(false);

    } catch (error) {
      console.error('Error updating user details:', error);
    }
  };
  const handleDelete = () =>
  {
     axios.delete(`http://localhost:8080/deletebyid/${transactionId}`)
     navigate('/signup');
  }
  return (
    <div id='profile'>
        <div className='overlay'>
      <h1>User Profile</h1>
      <div id='details'>

      <p>First Name: {userDetails.firstName}</p>
      <p>Last Name: {userDetails.lastName}</p>
      <p>Email: {userDetails.email}</p>
      <p>Password: {userDetails.password}</p>
      </div>
      <div id='buttons'>
      <button onClick={openEditModal}>Edit Profile</button>
      <button onClick={handleDelete}>Delete Profile</button>
      </div>

      <Modal
        isOpen={isEditModalOpen}
        onRequestClose={closeEditModal}
        contentLabel="Edit Profile Modal"
      >
        <h2>Edit Profile</h2>
        <label>
          First Name:
          <input
            type="text"
            name="firstName"
            value={editedUserDetails.firstName}
            onChange={(e) =>
              setEditedUserDetails({ ...editedUserDetails, firstName: e.target.value })
            }
          />
        </label>
        <label>
          Last Name:
          <input
            type="text"
            name="lastName"
            value={editedUserDetails.lastName}
            onChange={(e) =>
              setEditedUserDetails({ ...editedUserDetails, lastName: e.target.value })
            }
          />
        </label>
        <label>
          Email:
          <input
            type="email"
            name="email"
            value={editedUserDetails.email}
            onChange={(e) =>
              setEditedUserDetails({ ...editedUserDetails, email: e.target.value })
            }
          />
        </label>
        <label>
          Password:
          <input
            type="password"
            name="password"
            value={editedUserDetails.password}
            onChange={(e) =>
              setEditedUserDetails({ ...editedUserDetails, password: e.target.value })
            }
          />
        </label>
        <button onClick={handleSave}>Save</button>
        <button onClick={closeEditModal}>Cancel</button>
      </Modal>
      </div>
    </div>
  );
}

export default Profile;
