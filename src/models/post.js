export default class Post {
    constructor(title, description, category, subCategory, user) {
      this.title = title;
      this.description = description;
      this.category = category;
      this.subCategory = subCategory;
      this.user = user;
      this.likes = 0;
    }
  }