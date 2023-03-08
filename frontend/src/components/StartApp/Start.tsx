import axios from "axios";
import { BASE_URL } from "utils/requests";
import { useEffect, useState } from "react";

/* const baseURL = `${BASE_URL}/cpap/start`; */
const baseURL = `${BASE_URL}/cpap/uptime`;

function Start() {
  const [post, setPost] = useState(null);

  useEffect(() => {
    axios.get(baseURL).then((response) => {
      setPost(response.data);
    });
  }, []);

  if (!post) return null;

  /* return <div>Aplicação iniciada em {post}</div>; */
  return <div>Uptime: {post}</div>;
}

export default Start;
