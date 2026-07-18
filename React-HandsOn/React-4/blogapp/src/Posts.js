import React, { Component } from "react";
import Post from "./Post";
class Posts extends Component {
    constructor(props) {
        super(props);
        this.state = {
            posts: []
        };
    }
    loadPosts() {
        fetch("https://jsonplaceholder.typicode.com/posts")
            .then(response => response.json())
            .then(data => {
                const posts = data.map(item =>
                    new Post(item.id, item.title, item.body)
                );
                this.setState({
                    posts: posts
                });
            });
    }
    componentDidMount() {
        this.loadPosts();
    }
    componentDidCatch(error, info) {
        alert(error);
        console.log(info);
    }
    render() {
        return (
            <div>
                <h1>Blog Posts</h1>
                {
                    this.state.posts.map(post => (
                        <div
  key={post.id}
  style={{
    border: "1px solid #ccc",
    borderRadius: "8px",
    padding: "15px",
    margin: "15px",
    boxShadow: "0 2px 6px rgba(0,0,0,0.2)"
  }}
>
    <h3>{post.title}</h3>
    <p>{post.body}</p>
</div>
                    ))
                }
            </div>
        );
    }
}
export default Posts;