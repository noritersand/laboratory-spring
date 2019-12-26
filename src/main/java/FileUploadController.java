//
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
///**
// * 스프링과 함께하는 파일 업로드 시간!
// * 
// * @since 2017-08-11
// * @author fixalot
// */
//public class FileUploadController {
//	@SuppressWarnings("unused")
//	private static final Logger logger = LoggerFactory.getLogger(FileUploadController.class);
//	
//	@UrlMapping("/test/spring/spring-fileupload-test.view")
//	public View drawWithSpring(HttpServletRequest request, HttpServletResponse response) {
//		return new View(request);
//	}
//	
//	@UrlMapping("/test/spring/upload-file-with-spring.data")
//	public JsonResponseObject uploadWithSpring(HttpServletRequest request, HttpServletResponse response) throws IllegalStateException, IOException {
//		JsonResponseObject json = new JsonResponseObject();
//
//		if (!(request instanceof MultipartHttpServletRequest)) {
//			// multipart resolver 설정이 없으면 여기로 옴
//			json.setSuccess(false);
//			return json;
//		}
//		MultipartHttpServletRequest multipart = (MultipartHttpServletRequest) request;
//		
//		logger.debug("title: {}", multipart.getParameter("title")); // 입력된 문자
//		
//		Iterator<String> inputNames = multipart.getFileNames(); // 모든 파일 타입 인풋의 이름 반환
//		int index = 0;
//		List<Map<String, Object>> list = new LinkedList<>();
//		while (inputNames.hasNext()) {
//			final String inputName = inputNames.next();
//			MultipartFile uploadFile = multipart.getFile(inputName);
//			if (uploadFile == null) {
//				continue;
//			}
//			Path path = Paths.get("c:/laboratory/upload/" + uploadFile.getOriginalFilename());
//			uploadFile.transferTo(path.toFile()); // 임시 파일에 업로드 된 파일을 특정 폴더로 이동
//			Map<String, Object> map = new HashMap<String, Object>();
//			map.put("index", index);
//			map.put("content-type", uploadFile.getContentType());
//			map.put("original-file-name", uploadFile.getOriginalFilename());
//			map.put("absolute-path", path.toFile().getAbsolutePath());
//			map.put("file-size", uploadFile.getSize());
//			list.add(map);
//			++index;
//		}
//		
//		return json;
//	}
//}
