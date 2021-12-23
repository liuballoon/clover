/*
 Navicat Premium Data Transfer

 Source Server         : my
 Source Server Type    : MySQL
 Source Server Version : 80026
 Source Host           : localhost:3306
 Source Schema         : temp

 Target Server Type    : MySQL
 Target Server Version : 80026
 File Encoding         : 65001

 Date: 23/12/2021 17:29:44
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for address
-- ----------------------------
DROP TABLE IF EXISTS `address`;
CREATE TABLE `address`  (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '主键',
  `user_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户主键',
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '收件人名称',
  `phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '收件人手机号码',
  `province` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '省区',
  `city` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '市区',
  `detail_address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '详细地址',
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `delete_time` datetime NULL DEFAULT NULL COMMENT '删除时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '收货地址表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of address
-- ----------------------------

-- ----------------------------
-- Table structure for banner
-- ----------------------------
DROP TABLE IF EXISTS `banner`;
CREATE TABLE `banner`  (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '主键',
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '名称',
  `online` tinyint NOT NULL DEFAULT 1 COMMENT '是否在线（0否 1是）',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '描述',
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `delete_time` datetime NULL DEFAULT NULL COMMENT '删除时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '轮播图表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of banner
-- ----------------------------
INSERT INTO `banner` VALUES ('1454834043657367554', 'home', 1, '首页轮播图', '2021-10-31 23:34:00', '2021-12-22 12:45:50', NULL);

-- ----------------------------
-- Table structure for banner_item
-- ----------------------------
DROP TABLE IF EXISTS `banner_item`;
CREATE TABLE `banner_item`  (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '主键',
  `banner_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '轮播图主键',
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '名称',
  `cover_img` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '封面图',
  `type` tinyint UNSIGNED NOT NULL COMMENT '类型 (0商品 1专题 2活动)',
  `keyword` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '关键字',
  `sort` tinyint UNSIGNED NULL DEFAULT NULL COMMENT '排序',
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `delete_time` datetime NULL DEFAULT NULL COMMENT '删除时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '轮播图子项表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of banner_item
-- ----------------------------
INSERT INTO `banner_item` VALUES ('1451834093616367550', '1454834043657367554', '健身', 'https://aecpm.alicdn.com/imgextra/i3/3569880176/O1CN016ryher1DAeNcZKXEo_!!3569880176-0-alimamazszw.jpg', 1, 't1', 0, '2021-11-01 10:30:23', '2021-11-23 23:32:01', NULL);
INSERT INTO `banner_item` VALUES ('1454834013657363554', '1454834043657367554', '美食狂欢', 'https://img.mukewang.com/user/60c876710001dbc607500390.jpg', 1, 't1', 1, '2021-11-01 10:27:08', '2021-11-23 23:31:57', NULL);
INSERT INTO `banner_item` VALUES ('1454834073647363556', '1454834043657367554', '家居', 'https://img.mukewang.com/user/60c8766f0001d37e07500390.jpg', 1, 't1', 2, '2021-11-01 10:29:52', '2021-11-23 23:31:28', NULL);

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category`  (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '主键',
  `pid` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '父主键',
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '名称',
  `cover_img` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '封面图',
  `online` tinyint NOT NULL DEFAULT 1 COMMENT '是否在线（0否 1是）',
  `display` tinyint UNSIGNED NULL DEFAULT NULL COMMENT '是否为分类页选择项（0否 1是）',
  `sort` tinyint UNSIGNED NULL DEFAULT NULL COMMENT '排序',
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `delete_time` datetime NULL DEFAULT NULL COMMENT '删除时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '类目表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('1', NULL, '鞋靴', NULL, 1, 0, 1, '2021-11-08 17:23:59', '2021-11-21 20:41:37', NULL);
INSERT INTO `category` VALUES ('10', NULL, '食品', NULL, 1, 0, 10, '2021-11-08 17:23:59', '2021-12-09 22:43:56', NULL);
INSERT INTO `category` VALUES ('11', NULL, '玩具', NULL, 1, 1, 11, '2021-11-08 17:23:59', '2021-12-09 22:43:59', NULL);
INSERT INTO `category` VALUES ('111', '19', 'b', NULL, 1, NULL, NULL, '2021-11-28 01:23:58', '2021-11-28 01:23:58', NULL);
INSERT INTO `category` VALUES ('12', NULL, '图书', NULL, 1, 0, 12, '2021-11-08 17:23:59', '2021-11-21 20:41:37', NULL);
INSERT INTO `category` VALUES ('13', NULL, '礼品', NULL, 1, 0, 13, '2021-11-08 17:23:59', '2021-12-09 13:21:38', NULL);
INSERT INTO `category` VALUES ('14', NULL, '厨具', NULL, 1, 0, 14, '2021-11-08 17:23:59', '2021-12-09 22:44:02', NULL);
INSERT INTO `category` VALUES ('15', NULL, '户外', NULL, 1, 0, 15, '2021-11-08 17:23:59', '2021-12-09 22:44:00', NULL);
INSERT INTO `category` VALUES ('1555', '19', 'a', NULL, 1, NULL, NULL, '2021-11-28 01:23:48', '2021-11-28 01:23:48', NULL);
INSERT INTO `category` VALUES ('16', NULL, '乐器', NULL, 0, 0, 16, '2021-11-08 17:23:59', '2021-12-09 13:57:06', NULL);
INSERT INTO `category` VALUES ('17', NULL, '情趣', NULL, 0, 0, 17, '2021-11-08 17:23:59', '2021-12-09 13:57:02', NULL);
INSERT INTO `category` VALUES ('18', NULL, '奢侈品', NULL, 0, 0, 18, '2021-11-08 17:23:59', '2021-12-09 13:57:10', NULL);
INSERT INTO `category` VALUES ('19', '1', '平底鞋', 'https://img.alicdn.com/tps/TB14dOLJFXXXXc2XFXXXXXXXXXX-110-110.jpg', 1, 0, NULL, '2021-11-08 17:23:59', '2021-11-21 20:41:37', NULL);
INSERT INTO `category` VALUES ('2', NULL, '包包', NULL, 1, 0, 2, '2021-11-08 17:23:59', '2021-11-21 20:41:37', NULL);
INSERT INTO `category` VALUES ('20', '1', '板鞋', 'https://img.alicdn.com/tps/TB1crUcLVXXXXXVXFXXXXXXXXXX-140-140.png', 1, 0, NULL, '2021-11-08 17:23:59', '2021-11-21 20:41:37', NULL);
INSERT INTO `category` VALUES ('21', '1', '乐福鞋', 'https://img.alicdn.com/tps/TB1ToEiLVXXXXalXpXXXXXXXXXX-140-140.png', 1, 0, NULL, '2021-11-08 17:23:59', '2021-11-21 20:41:37', NULL);
INSERT INTO `category` VALUES ('22', '1', '高跟鞋', 'https://img.alicdn.com/tps/TB1bxiYJFXXXXa6XpXXXXXXXXXX-144-144.jpg', 1, 0, NULL, '2021-11-08 17:23:59', '2021-11-21 20:41:37', NULL);
INSERT INTO `category` VALUES ('23', '1', '拖鞋', 'https://img.alicdn.com/tps/TB1eZclLVXXXXc2XXXXXXXXXXXX-140-140.png', 1, 0, NULL, '2021-11-08 17:23:59', '2021-11-21 20:41:37', NULL);
INSERT INTO `category` VALUES ('24', '1', '凉鞋', 'https://img.alicdn.com/tps/TB1LJSCJFXXXXbgXVXXXXXXXXXX-150-150.jpg', 1, 0, NULL, '2021-11-08 17:23:59', '2021-11-21 20:41:37', NULL);
INSERT INTO `category` VALUES ('25', '7', '手机', '//img13.360buyimg.com/n1/s450x450_jfs/t1/125314/19/19567/155978/60b5ac9dEd519360f/683196a9a0477cc1.jpg', 1, 0, NULL, '2021-11-08 17:23:59', '2021-11-21 20:41:37', NULL);
INSERT INTO `category` VALUES ('26', '7', '耳麦', '//img.alicdn.com/tfs/TB1xiR3nMgP7K4jSZFqXXamhVXa-800-800.jpg', 1, 0, NULL, '2021-11-08 17:23:59', '2021-11-21 20:41:37', NULL);
INSERT INTO `category` VALUES ('27', '7', '平板', '//img11.360buyimg.com/n1/s450x450_jfs/t1/192937/4/5773/66436/60b47804E7434f8a4/8c14331748fb4606.jpg', 1, 0, NULL, '2021-11-08 17:23:59', '2021-11-21 20:41:37', NULL);
INSERT INTO `category` VALUES ('28', '7', '电脑', '//img14.360buyimg.com/n1/s450x450_jfs/t1/141480/8/14039/48663/5fab0686E7d32b85f/bb2489ac5d2b4ed5.jpg', 1, 0, NULL, '2021-11-08 17:23:59', '2021-11-21 20:41:37', NULL);
INSERT INTO `category` VALUES ('29', '7', '智能手表', '//img13.360buyimg.com/n1/s450x450_jfs/t1/74443/20/13151/158361/5da5379aEf0a4b3cd/12ad83d6aa16b305.jpg', 1, 0, NULL, '2021-11-08 17:23:59', '2021-11-21 20:41:37', NULL);
INSERT INTO `category` VALUES ('3', NULL, '服装', NULL, 1, 0, 3, '2021-11-08 17:23:59', '2021-11-21 20:41:37', NULL);
INSERT INTO `category` VALUES ('30', '7', '游戏机', '//img14.360buyimg.com/n5/s450x450_jfs/t1/137181/16/19395/36702/5fd31626Ecd7c2a7f/f187279a42344d00.jpg', 1, 0, NULL, '2021-11-08 17:23:59', '2021-11-21 20:41:37', NULL);
INSERT INTO `category` VALUES ('31', '6', '口红', '//img.alicdn.com/tfs/TB1jsZxlIieb18jSZFvXXaI3FXa-400-400.jpg//img.alicdn.com/tfs/TB1jsZxlIieb18jSZFvXXaI3FXa-400-400.jpg', 1, 0, NULL, '2021-11-08 17:23:59', '2021-11-21 20:41:37', NULL);
INSERT INTO `category` VALUES ('32', '6', '防晒', 'https://img.alicdn.com/imgextra/i4/2582702075/O1CN01SQc8XJ1RCONHzP28P_!!2582702075.jpg', 1, 0, NULL, '2021-11-08 17:23:59', '2021-11-21 20:41:37', NULL);
INSERT INTO `category` VALUES ('33', '6', '香水', 'https://img.alicdn.com/imgextra/i3/2200676153815/O1CN01jLE8fZ1e3JWojaOgt_!!2200676153815.jpg', 1, 0, NULL, '2021-11-08 17:23:59', '2021-11-21 20:41:37', NULL);
INSERT INTO `category` VALUES ('34', '6', '精华液', 'https://img.alicdn.com/imgextra/i4/2424298091/O1CN01aZwlxb29dj6elXsgp_!!2424298091.jpg', 1, 0, NULL, '2021-11-08 17:23:59', '2021-11-21 20:41:37', NULL);
INSERT INTO `category` VALUES ('35', '6', '粉底液', '//img.alicdn.com/imgextra/i3/2064892827/O1CN01aYAZJK1WkoDVq9B8Y_!!2064892827.jpg', 1, 0, NULL, '2021-11-08 17:24:00', '2021-11-21 20:41:37', NULL);
INSERT INTO `category` VALUES ('36', '6', '卸妆', 'https://img.alicdn.com/imgextra/i3/2563613536/O1CN01DTP5jT1bzWy9xba4q_!!2563613536.jpg', 1, 0, NULL, '2021-11-08 17:24:00', '2021-11-21 20:41:37', NULL);
INSERT INTO `category` VALUES ('37', '6', '隔离', 'https://img.alicdn.com/imgextra/i2/2563613536/O1CN01paCm0E1bzWyA4nViO_!!2563613536.jpg', 1, 0, NULL, '2021-11-08 17:24:00', '2021-11-21 20:41:37', NULL);
INSERT INTO `category` VALUES ('38', '6', '面膜', '//img.alicdn.com/imgextra/i4/2113741929/O1CN01vKIVb71Q7WY9c6PR6_!!2113741929.jpg', 1, 0, NULL, '2021-11-08 17:24:00', '2021-11-21 20:41:37', NULL);
INSERT INTO `category` VALUES ('39', '6', '眼霜', 'https://img.alicdn.com/imgextra/i2/2064892827/O1CN01zE7GkZ1WkoDTn38Cn_!!2064892827.jpg', 1, 0, NULL, '2021-11-08 17:24:00', '2021-11-21 20:41:37', NULL);
INSERT INTO `category` VALUES ('4', NULL, '居家', NULL, 1, 0, 4, '2021-11-08 17:23:59', '2021-11-21 20:41:37', NULL);
INSERT INTO `category` VALUES ('40', '8', '冰箱', '//img.alicdn.com/tfs/TB1am1xO4TpK1RjSZR0XXbEwXXa-400-400.png', 1, 0, NULL, '2021-11-08 17:24:00', '2021-11-21 20:41:37', NULL);
INSERT INTO `category` VALUES ('41', '8', '电视机', '//img.alicdn.com/tps/O1CN010qisDc1ZHu0cFXfxT_!!3818963170-0-daren.jpg', 1, 0, NULL, '2021-11-08 17:24:00', '2021-11-21 20:41:37', NULL);
INSERT INTO `category` VALUES ('42', '8', '洗衣机', '//img.alicdn.com/tfs/TB1lsmIO9zqK1RjSZFjXXblCFXa-400-400.png', 1, 0, NULL, '2021-11-08 17:24:00', '2021-11-21 20:41:37', NULL);
INSERT INTO `category` VALUES ('43', '8', '电饭煲', '//img.alicdn.com/tfs/TB13nKbhTZmx1VjSZFGXXax2XXa-619-619.jpg', 1, 0, NULL, '2021-11-08 17:24:00', '2021-11-21 20:41:37', NULL);
INSERT INTO `category` VALUES ('45', '4', '沙发', '//img.alicdn.com/tfs/TB1RfBzcRKw3KVjSZTEXXcuRpXa-400-400.jpg', 1, 0, NULL, '2021-11-08 17:24:00', '2021-11-21 20:41:37', NULL);
INSERT INTO `category` VALUES ('47', '4', '茶几', 'https://img.alicdn.com/imgextra/i3/1105025069/O1CN01ycQ7k21nJeA1Xk2LQ_!!1105025069.jpg_430x430q90.jpg', 1, 0, NULL, '2021-11-08 17:24:00', '2021-11-21 20:41:37', NULL);
INSERT INTO `category` VALUES ('48', '4', '床', '//img.alicdn.com/tfs/TB1fG0tcROD3KVjSZFFXXcn9pXa-400-400.jpg', 1, 0, NULL, '2021-11-08 17:24:00', '2021-11-21 20:41:37', NULL);
INSERT INTO `category` VALUES ('5', NULL, '首饰', NULL, 1, 0, 5, '2021-11-08 17:23:59', '2021-11-21 20:41:37', NULL);
INSERT INTO `category` VALUES ('50', NULL, '文学社科', 'https://img.alicdn.com/imgextra/i3/761018214/O1CN01XehDrC2AY3ocZwp8a_!!0-item_pic.jpg_430x430q90.jpg', 1, 0, NULL, '2021-11-08 17:24:00', '2021-12-09 13:22:59', NULL);
INSERT INTO `category` VALUES ('52', '12', '生活艺术', 'https://gw.alicdn.com/tfs/TB1lz1TawKG3KVjSZFLXXaMvXXa-415-425.jpg', 1, 0, NULL, '2021-11-08 17:24:00', '2021-11-21 20:41:37', NULL);
INSERT INTO `category` VALUES ('53', '12', '科学技术', 'https://gw.alicdn.com/tfs/TB1j49VaB1D3KVjSZFyXXbuFpXa-800-800.png', 1, 0, NULL, '2021-11-08 17:24:00', '2021-11-21 20:41:37', NULL);
INSERT INTO `category` VALUES ('55', NULL, '教材教辅', 'https://gw.alicdn.com/tfs/TB1UYi4arys3KVjSZFnXXXFzpXa-800-800.png', 1, 0, NULL, '2021-11-08 17:24:00', '2021-12-09 13:22:55', NULL);
INSERT INTO `category` VALUES ('56', '5', '戒指', '//img.alicdn.com/tfs/TB1gg2UPXY7gK0jSZKzXXaikpXa-400-400.jpg', 1, 0, NULL, '2021-11-08 17:24:00', '2021-11-21 20:41:37', NULL);
INSERT INTO `category` VALUES ('57', '5', '项链', '//img.alicdn.com/tfs/TB1o.KLe2zO3e4jSZFxXXaP_FXa-400-400.jpg', 1, 0, NULL, '2021-11-08 17:24:00', '2021-11-21 20:41:37', NULL);
INSERT INTO `category` VALUES ('58', '5', '手链', '//img.alicdn.com/bao/uploaded/i2/TB1laqAe9zqK1RjSZPcSuvTepXa.jpg', 1, 0, NULL, '2021-11-08 17:24:00', '2021-11-21 20:41:37', NULL);
INSERT INTO `category` VALUES ('59', '5', '手表', '//img.alicdn.com/bao/uploaded/i1/TB1jxDiTRLoK1RjSZFuSutn0XXa.jpg', 1, 0, NULL, '2021-11-08 17:24:00', '2021-11-21 20:41:37', NULL);
INSERT INTO `category` VALUES ('6', NULL, '美妆', NULL, 1, 0, 6, '2021-11-08 17:23:59', '2021-11-21 20:41:37', NULL);
INSERT INTO `category` VALUES ('60', '5', '耳钉', '//img.alicdn.com/bao/uploaded/i2/TB1NlmMMSzqK1RjSZFLSuwn2XXa.jpg', 1, 0, NULL, '2021-11-08 17:24:00', '2021-11-21 20:41:37', NULL);
INSERT INTO `category` VALUES ('61', '16', '钢琴', NULL, 1, 0, NULL, '2021-11-08 17:24:00', '2021-11-21 20:41:37', NULL);
INSERT INTO `category` VALUES ('62', NULL, '吉他', NULL, 1, 0, NULL, '2021-11-08 17:24:00', '2021-12-09 22:43:46', NULL);
INSERT INTO `category` VALUES ('63', NULL, '口琴', NULL, 1, 0, NULL, '2021-11-08 17:24:00', '2021-12-09 22:43:47', NULL);
INSERT INTO `category` VALUES ('64', '16', '竹笛', NULL, 1, 0, NULL, '2021-11-08 17:24:00', '2021-11-21 20:41:37', NULL);
INSERT INTO `category` VALUES ('65', '16', '古筝', NULL, 1, 0, NULL, '2021-11-08 17:24:00', '2021-11-21 20:41:37', NULL);
INSERT INTO `category` VALUES ('66', '16', '萨克斯', NULL, 1, 0, NULL, '2021-11-08 17:24:00', '2021-11-21 20:41:37', NULL);
INSERT INTO `category` VALUES ('67', '3', '帽子', '//img12.360buyimg.com/n1/jfs/t1/144313/8/19173/58484/5fdec990E99c8e074/91883c67b4f47428.jpg', 1, 0, NULL, '2021-11-08 17:24:00', '2021-11-21 20:41:37', NULL);
INSERT INTO `category` VALUES ('68', '3', '针织衫', '//img.alicdn.com/tfs/TB1h_YdcAWE3KVjSZSyXXXocXXa-800-800.jpg', 1, 0, NULL, '2021-11-08 17:24:00', '2021-11-21 20:41:37', NULL);
INSERT INTO `category` VALUES ('69', '3', '袜子', '//img.alicdn.com/tfs/TB1XlDRPhz1gK0jSZSgXXavwpXa-400-400.jpg', 1, 0, NULL, '2021-11-08 17:24:00', '2021-11-21 20:41:37', NULL);
INSERT INTO `category` VALUES ('7', NULL, '数码', NULL, 1, 0, 7, '2021-11-08 17:23:59', '2021-11-21 20:41:37', NULL);
INSERT INTO `category` VALUES ('70', '3', '睡衣', '//img.alicdn.com/imgextra/i4/1625321223/TB2_ffFmrtlpuFjSspfXXXLUpXa_!!1625321223.jpg', 1, 0, NULL, '2021-11-08 17:24:00', '2021-11-21 20:41:37', NULL);
INSERT INTO `category` VALUES ('74', '2', '小方包', '//img12.360buyimg.com/n1/jfs/t1/133296/36/77/78619/5ec88335E4b9a5fbc/60f12b78a4a0b24c.jpg', 1, 0, NULL, '2021-11-08 17:24:00', '2021-11-21 20:41:37', NULL);
INSERT INTO `category` VALUES ('75', '2', '迷你包', '//img14.360buyimg.com/n1/jfs/t1/195599/40/6812/148063/60bd852bEbfd0a72e/8ee468a0bd56fbed.jpg', 1, 0, NULL, '2021-11-08 17:24:00', '2021-11-21 20:41:37', NULL);
INSERT INTO `category` VALUES ('76', '2', '手拿包', '//img10.360buyimg.com/n1/jfs/t1/162432/33/18398/132037/6076a04aE45e969b5/b6df2d34fdcde86b.jpg', 1, 0, NULL, '2021-11-08 17:24:00', '2021-11-21 20:41:37', NULL);
INSERT INTO `category` VALUES ('8', NULL, '家电', NULL, 1, 0, 8, '2021-11-08 17:23:59', '2021-12-09 22:43:49', NULL);
INSERT INTO `category` VALUES ('9', NULL, '日用品', NULL, 1, 0, 9, '2021-11-08 17:23:59', '2021-12-09 22:43:51', NULL);

-- ----------------------------
-- Table structure for navigation
-- ----------------------------
DROP TABLE IF EXISTS `navigation`;
CREATE TABLE `navigation`  (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '主键',
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '名称',
  `cover_img` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '封面图',
  `type` tinyint UNSIGNED NOT NULL COMMENT '类型 (0分类 1专题)',
  `keyword` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '关键字',
  `online` tinyint NOT NULL DEFAULT 1 COMMENT '是否在线（0否 1是）',
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `delete_time` datetime NULL DEFAULT NULL COMMENT '删除时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '导航表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of navigation
-- ----------------------------

-- ----------------------------
-- Table structure for spec_key
-- ----------------------------
DROP TABLE IF EXISTS `spec_key`;
CREATE TABLE `spec_key`  (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '主键',
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '名称',
  `unit` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '单位',
  `online` tinyint NOT NULL DEFAULT 1 COMMENT '是否在线（0否 1是）',
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `delete_time` datetime NULL DEFAULT NULL COMMENT '删除时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '规格名表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of spec_key
-- ----------------------------

-- ----------------------------
-- Table structure for spec_value
-- ----------------------------
DROP TABLE IF EXISTS `spec_value`;
CREATE TABLE `spec_value`  (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '主键',
  `spec_key_id` int NOT NULL COMMENT '规格名主键',
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '名称',
  `online` tinyint NOT NULL DEFAULT 1 COMMENT '是否在线（0否 1是）',
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `delete_time` datetime NULL DEFAULT NULL COMMENT '删除时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '规格值表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of spec_value
-- ----------------------------

-- ----------------------------
-- Table structure for spu
-- ----------------------------
DROP TABLE IF EXISTS `spu`;
CREATE TABLE `spu`  (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '主键',
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '标题',
  `cover_img` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '封面图',
  `price` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '价格',
  `discount_price` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '折扣价',
  `tags` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '标签',
  `online` tinyint NOT NULL DEFAULT 1 COMMENT '是否在线（0否 1是）',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '描述',
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `delete_time` datetime NULL DEFAULT NULL COMMENT '删除时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '商品表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of spu
-- ----------------------------
INSERT INTO `spu` VALUES ('1', '解放橘郡 像你的人100ml', 'https://gd2.alicdn.com/imgextra/i2/2368381957/O1CN01C2no491QKLm7gM5YA_!!2368381957.jpg_400x400.jpg', '699', NULL, '薄荷味', 1, '我遇见的都是像你的人', '2021-12-21 23:35:25', '2021-12-23 17:13:38', NULL);
INSERT INTO `spu` VALUES ('10', '马氏皇庭 北欧皮布冬夏两用沙发', 'https://img.alicdn.com/imgextra/i2/823349039/O1CN01ulbtcW2GdueiD3JQs_!!823349039-0-lubanu-s.jpg_430x430q90.jpg', '12299', NULL, NULL, 1, '皮布双面设计 白蜡木实木脚 水性漆', '2021-12-21 23:35:25', '2021-12-21 23:35:25', NULL);
INSERT INTO `spu` VALUES ('11', '源氏木语实木茶几北欧橡木茶台', 'https://img.alicdn.com/imgextra/i2/1105025069/TB2iN0RqxGYBuNjy0FnXXX5lpXa_!!1105025069.jpg_430x430q90.jpg', '1268', NULL, NULL, 1, '进口FAS级橡木 圆润倒角 榫卯整装', '2021-12-21 23:35:25', '2021-12-21 23:35:25', NULL);
INSERT INTO `spu` VALUES ('12', '周大福星情侣对戒正品PT950铂金戒指', 'https://gd4.alicdn.com/imgextra/i1/0/O1CN01xt7D3S1Rr9kI7g2Rc_!!0-item_pic.jpg_400x400.jpg', '530', NULL, NULL, 1, '求婚白金莫桑石钻戒素圈男女\r\n', '2021-12-21 23:35:25', '2021-12-21 23:35:25', NULL);
INSERT INTO `spu` VALUES ('13', 'COGU陀飞轮手表男士机械表镂空', 'https://img.alicdn.com/imgextra/i4/3236722345/TB2WWS1tr0kpuFjy0FjXXcBbVXa_!!3236722345.jpg_430x430q90.jpg', '99800', NULL, NULL, 1, '陀飞轮机械机芯，表盘镶嵌10颗钻石', '2021-12-21 23:35:25', '2021-12-21 23:35:25', NULL);
INSERT INTO `spu` VALUES ('14', '拿火吉他LAVA ME 2碳纤维民谣吉他初学者入门学生36寸男女', 'https://img.alicdn.com/imgextra/https://img.alicdn.com/imgextra/i1/2487209081/O1CN01xOHP4W2Gx9HJtE8ez_!!2487209081.jpg_430x430q90.jpg', '2888', NULL, '吉他', 1, '全新FreeBoost功能', '2021-12-21 23:35:25', '2021-12-23 17:13:51', NULL);
INSERT INTO `spu` VALUES ('2', 'Leopold 利奥博德FC980M机械键盘', 'https://img.alicdn.com/imgextra/i1/3671215664/O1CN012J7CfY1ri9yj9W3ay_!!3671215664.jpg_430x430q90.jpg', '1199', '1099', NULL, 1, '属于你的退烧键盘', '2021-12-21 23:35:25', '2021-12-23 15:00:15', NULL);
INSERT INTO `spu` VALUES ('3', '时尚针织衫', 'https://gd3.alicdn.com/imgextra/i3/2602370342/O1CN01MSV3091EOg7IndHfy_!!2602370342.png_400x400.jpg', '77', NULL, NULL, 1, '', '2021-12-21 23:35:25', '2021-12-21 23:35:25', NULL);
INSERT INTO `spu` VALUES ('4', '金士顿HyperX Cloud Flight天箭', 'https://img.alicdn.com/imgextra/i1/704392951/O1CN01MxUxOP1XfbTWDoYrW_!!704392951-0-picasso.jpg_430x430q90.jpg', '869', NULL, '无线#续航', 1, '2.4Ghz电竞级无线 30h长效电力 舒适不压头', '2021-12-21 23:35:25', '2021-12-23 17:14:03', NULL);
INSERT INTO `spu` VALUES ('5', '2021新款ipadpro11保护套带笔槽', 'https://img.alicdn.com/imgextra/i4/1779343388/O1CN016nAyWM1atkWln1and_!!1779343388.jpg_430x430q90.jpg', '69', NULL, NULL, 1, '硅胶第二代硬壳全包防摔透明', '2021-12-21 23:35:25', '2021-12-21 23:36:53', NULL);
INSERT INTO `spu` VALUES ('6', 'Steelseries赛睿 Aerox 3系列', 'https://img.alicdn.com/imgextra/i3/4037368186/O1CN01chKYfg2ALEr6FJjnM_!!4037368186.jpg_430x430q90.jpg', '749', NULL, NULL, 1, '超轻量化设计 TrueMove Air 光学游戏传感器', '2021-12-21 23:35:25', '2021-12-21 23:35:25', NULL);
INSERT INTO `spu` VALUES ('7', '向往镇东隆咚首本个人插画集', 'https://gd3.alicdn.com/imgextra/i4/3470811498/O1CN0130nmhT1Mw7z7EXpHZ_!!3470811498.jpg_400x400.jpg', '98', NULL, NULL, 1, '温馨治愈清新可爱', '2021-12-21 23:35:25', '2021-12-21 23:35:25', NULL);
INSERT INTO `spu` VALUES ('8', 'CHANEL香奈儿炫亮魅力丝绒唇膏狮子系列', 'https://img.alicdn.com/imgextra/i3/4207517744/O1CN01RPRpOu274niVyRqok_!!0-item_pic.jpg_430x430q90.jpg', '340', NULL, NULL, 1, '', '2021-12-21 23:35:25', '2021-12-21 23:35:25', NULL);
INSERT INTO `spu` VALUES ('9', '纪梵希散粉蜜粉四宫格1号2#5#7', 'https://img.alicdn.com/imgextra/i3/692011888/O1CN016kyAa91PokK55qpC4_!!692011888.jpg_400x400.jpg', '388', NULL, NULL, 1, '定妆控油轻盈无痕细腻持久', '2021-12-21 23:35:25', '2021-12-21 23:35:25', NULL);

-- ----------------------------
-- Table structure for spu_display
-- ----------------------------
DROP TABLE IF EXISTS `spu_display`;
CREATE TABLE `spu_display`  (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '主键',
  `spu_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '商品主键',
  `img` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '图片',
  `online` tinyint NOT NULL DEFAULT 1 COMMENT '是否在线（0否 1是）',
  `sort` tinyint UNSIGNED NULL DEFAULT NULL COMMENT '排序',
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `delete_time` datetime NULL DEFAULT NULL COMMENT '删除时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '商品展示表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of spu_display
-- ----------------------------
INSERT INTO `spu_display` VALUES ('1', '14', 'https://img.alicdn.com/imgextra/https://img.alicdn.com/imgextra/i3/2487209081/O1CN01uRW3LZ2Gx9JV3P1B4_!!2487209081.jpg_430x430q90.jpg', 1, 3, '2021-12-23 15:23:56', '2021-12-23 15:38:48', NULL);
INSERT INTO `spu_display` VALUES ('2', '14', 'https://img.alicdn.com/imgextra/https://img.alicdn.com/imgextra/i1/2487209081/O1CN01xOHP4W2Gx9HJtE8ez_!!2487209081.jpg_430x430q90.jpg', 1, 2, '2021-12-23 15:24:05', '2021-12-23 15:35:36', NULL);
INSERT INTO `spu_display` VALUES ('3', '14', 'https://img.alicdn.com/imgextra/https://img.alicdn.com/imgextra/i2/2487209081/O1CN01rUnIfl2Gx9H8YW0DD_!!2487209081.jpg_430x430q90.jpg', 1, 1, '2021-12-23 15:24:15', '2021-12-23 15:35:38', NULL);
INSERT INTO `spu_display` VALUES ('4', '14', 'https://img.alicdn.com/imgextra/i1/2928964165/O1CN01eidfN51gdcGSz3yhg_!!2928964165.jpg_430x430q90.jpg', 1, 2, '2021-12-23 15:24:23', '2021-12-23 15:38:45', NULL);

-- ----------------------------
-- Table structure for spu_evaluation
-- ----------------------------
DROP TABLE IF EXISTS `spu_evaluation`;
CREATE TABLE `spu_evaluation`  (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '主键',
  `spu_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '商品主键',
  `user_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户主键',
  `nickname` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户昵称',
  `rate` tinyint UNSIGNED NOT NULL COMMENT '评分（五星制）',
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '评论内容',
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `delete_time` datetime NULL DEFAULT NULL COMMENT '删除时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '商品评价表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of spu_evaluation
-- ----------------------------

-- ----------------------------
-- Table structure for spu_introduce
-- ----------------------------
DROP TABLE IF EXISTS `spu_introduce`;
CREATE TABLE `spu_introduce`  (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '主键',
  `spu_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '商品主键',
  `img` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '图片',
  `online` tinyint NOT NULL DEFAULT 1 COMMENT '是否在线（0否 1是）',
  `sort` tinyint UNSIGNED NOT NULL COMMENT '排序',
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `delete_time` datetime NULL DEFAULT NULL COMMENT '删除时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '商品介绍表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of spu_introduce
-- ----------------------------
INSERT INTO `spu_introduce` VALUES ('1', '14', 'https://img.alicdn.com/imgextra/i1/2487209081/O1CN015B5d4z2Gx9LgKUlxp_!!2487209081.jpg', 1, 3, '2021-06-23 16:07:54', '2021-12-23 15:39:33', NULL);
INSERT INTO `spu_introduce` VALUES ('2', '14', 'https://img.alicdn.com/imgextra/i1/2487209081/O1CN01nzTwYd2Gx9LlSChDf_!!2487209081.jpg', 1, 0, '2021-06-23 16:08:49', '2021-12-23 15:39:35', NULL);
INSERT INTO `spu_introduce` VALUES ('3', '14', 'https://img.alicdn.com/imgextra/i3/2487209081/O1CN01OMlrPm2Gx9LqhOeT1_!!2487209081.jpg', 1, 2, '2021-06-23 16:08:52', NULL, NULL);
INSERT INTO `spu_introduce` VALUES ('4', '14', 'https://img.alicdn.com/imgextra/i4/2487209081/O1CN01Qck8EX2Gx9LkkDM6b_!!2487209081.jpg', 1, 1, '2021-06-23 16:09:03', '2021-12-23 15:39:28', NULL);
INSERT INTO `spu_introduce` VALUES ('5', '14', 'https://img.alicdn.com/imgextra/i4/2487209081/O1CN018KRsze2Gx9IvHIjC6_!!2487209081.jpg', 1, 4, '2021-06-23 16:09:14', NULL, NULL);
INSERT INTO `spu_introduce` VALUES ('6', '14', 'https://img.alicdn.com/imgextra/i2/2487209081/O1CN01jtcLGr2Gx9LhhRXGE_!!2487209081.jpg', 1, 6, '2021-06-23 16:09:22', '2021-12-23 15:39:36', NULL);
INSERT INTO `spu_introduce` VALUES ('7', '14', 'https://img.alicdn.com/imgextra/i3/2487209081/O1CN01wmYKZL2Gx9LljIofL_!!2487209081.jpg', 1, 5, '2021-06-23 16:09:31', '2021-12-23 15:39:39', NULL);

-- ----------------------------
-- Table structure for theme
-- ----------------------------
DROP TABLE IF EXISTS `theme`;
CREATE TABLE `theme`  (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '主键',
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '名称',
  `template_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '模板名称',
  `cover_img` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '封面图',
  `online` tinyint NOT NULL DEFAULT 1 COMMENT '是否在线（0否 1是）',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '描述',
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `delete_time` datetime NULL DEFAULT NULL COMMENT '删除时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '专题表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of theme
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '主键',
  `nickname` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '昵称',
  `username` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `password` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '密码',
  `avatar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '头像',
  `gender` tinyint UNSIGNED NULL DEFAULT 0 COMMENT '性别（0保密 1男 2女）',
  `birth_date` date NULL DEFAULT NULL COMMENT '出生日期',
  `phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '手机号码',
  `email` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '电子邮箱',
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `delete_time` datetime NULL DEFAULT NULL COMMENT '删除时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
